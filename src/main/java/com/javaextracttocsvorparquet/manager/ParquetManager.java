package com.javaextracttocsvorparquet.manager;

import com.javaextracttocsvorparquet.models.Cars;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.reflect.ReflectData;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.io.OutputFile;
import org.apache.hadoop.fs.Path;

import java.io.InputStream;
import java.util.ArrayList;

public class ParquetManager {

    public static void writeListToParquet(ArrayList<Cars> list, String filePath) throws Exception {
        // Load the schema from the .avsc file in the classpath
        InputStream schemaStream = ParquetManager.class.getResourceAsStream("/avro/Cars.avsc");
        if (schemaStream == null) {
            throw new RuntimeException("Could not find Avro schema file /avro/Cars.avsc");
        }

        Schema schema = new Schema.Parser().parse(schemaStream);

        Path outputPath = new Path(filePath + "/data.parquet");

        ParquetWriter<GenericRecord> writer = AvroParquetWriter.<GenericRecord>builder(outputPath)
                .withSchema(schema)
                .build();
        for (Cars item : list) {
            GenericRecord genericItem = item.convertPojoToAvroRecord(item);
            writer.write(genericItem);
        }
        writer.close();
    }
}
