package com.javaextracttocsvorparquet.manager;

import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.io.OutputFile;

import java.nio.file.Path;
import java.util.ArrayList;

public class ParquetManager {

    public static <T> void writeListToParquet(ArrayList<T> list, String filePath, Class<T> clazz) throws Exception {
        Schema schema = ReflectData.AllowNull.get().getSchema(clazz);

        ParquetWriter<T> writer = AvroParquetWriter.<T>builder((OutputFile) Path.of(filePath))
                .withSchema(schema)
                .build();
        for (T item : list) {
            writer.write(item);
        }
        writer.close();
    }
}
