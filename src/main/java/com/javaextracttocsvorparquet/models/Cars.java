package com.javaextracttocsvorparquet.models;


import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.IOException;

public class Cars {

    private String buying;
    private String maint;
    private String doors;
    private String persons;
    private String lug_boot;
    private String safety;
    
    public String getBuying() {
        return buying;
    }
    public void setBuying(String buying) {
        this.buying = buying;
    }
    public String getMaint() {
        return maint;
    }
    public void setMaint(String maint) {
        this.maint = maint;
    }
    public String getDoors() {
        return doors;
    }
    public void setDoors(String doors) {
        this.doors = doors;
    }
    public String getPersons() {
        return persons;
    }
    public void setPersons(String persons) {
        this.persons = persons;
    }
    public String getLugBoot() {
        return lug_boot;
    }
    public void setLugBoot(String lug_boot) {
        this.lug_boot = lug_boot;
    }
    public String getSafety() {
        return safety;
    }
    public void setSafety(String safety) {
        this.safety = safety;
    }

    public Cars(String buying, String maint, String doors, String persons, String lug_boot, String safety) {
        this.buying = buying;
        this.maint = maint;
        this.doors = doors;
        this.persons = persons;
        this.lug_boot = lug_boot;
        this.safety = safety;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((buying == null) ? 0 : buying.hashCode());
        result = prime * result + ((maint == null) ? 0 : maint.hashCode());
        result = prime * result + ((doors == null) ? 0 : doors.hashCode());
        result = prime * result + ((persons == null) ? 0 : persons.hashCode());
        result = prime * result + ((lug_boot == null) ? 0 : lug_boot.hashCode());
        result = prime * result + ((safety == null) ? 0 : safety.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cars other = (Cars) obj;
        if (buying == null) {
            if (other.buying != null)
                return false;
        } else if (!buying.equals(other.buying))
            return false;
        if (maint == null) {
            if (other.maint != null)
                return false;
        } else if (!maint.equals(other.maint))
            return false;
        if (doors == null) {
            if (other.doors != null)
                return false;
        } else if (!doors.equals(other.doors))
            return false;
        if (persons == null) {
            if (other.persons != null)
                return false;
        } else if (!persons.equals(other.persons))
            return false;
        if (lug_boot == null) {
            if (other.lug_boot != null)
                return false;
        } else if (!lug_boot.equals(other.lug_boot))
            return false;
        if (safety == null) {
            if (other.safety != null)
                return false;
        } else if (!safety.equals(other.safety))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "cars [buying=" + buying + ", maint=" + maint + ", doors=" + doors + ", persons=" + persons
                + ", lugBoot=" + lug_boot + ", safety=" + safety + "]";
    }

    public GenericRecord convertPojoToAvroRecord(Cars car) throws IOException {
        // Get the Avro schema from the POJO class using reflection
        Schema schema = ReflectData.get().getSchema(car.getClass());

        // Create a ReflectDatumWriter for the POJO
        ReflectDatumWriter<Cars> datumWriter = new ReflectDatumWriter<>(schema);

        // Write the POJO to a GenericRecord
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(outputStream, null);
        datumWriter.write(car, encoder);
        encoder.flush();

        // Create a GenericRecord and populate it (this step might be implicit depending on usage)
        // For direct conversion to GenericRecord, you might use a different approach or
        // deserialize from the byte array.
        // A more direct way to get a GenericRecord is often needed for dynamic schema handling.
        // For this example, we'll assume the goal is to get a serialized form or
        // directly use the ReflectDatumWriter for writing.

        // If you need a GenericRecord object directly, you could create one and then populate it
        // based on the POJO fields. However, ReflectDatumWriter is primarily for serialization.
        // For direct GenericRecord creation from a POJO, you might manually map fields or
        // use libraries like Avro-Jackson.

        // The above code primarily demonstrates writing the POJO to an Avro binary format.
        // To get a GenericRecord, you'd typically read this binary data back using a GenericDatumReader.
        // Or, for simpler cases, manually construct a GenericRecord:
        GenericRecord avroRecord = new GenericData.Record(schema);
        avroRecord.put("buying", car.buying);
        avroRecord.put("maint", car.maint);
        avroRecord.put("doors", car.doors);
        avroRecord.put("persons", car.persons);
        avroRecord.put("lug_boot", car.lug_boot);
        avroRecord.put("safety", car.safety);
        return avroRecord;
    }


}
