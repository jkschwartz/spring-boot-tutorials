package com.baeldung.avro;

import generated.avro.Car;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

public class SerializationDeserializationLogic {

    static void serializeCar(Car car) throws IOException {

        DatumWriter<Car> userDatumWriter = new SpecificDatumWriter(Car.class);
        DataFileWriter<Car> dataFileWriter = new DataFileWriter(userDatumWriter);
        dataFileWriter.create(car.getSchema(), new File("cars.avro"));
        dataFileWriter.append(car);
        dataFileWriter.close();
    }

    static Car deserializeCar() throws IOException {

        DatumReader<Car> userDatumReader = new SpecificDatumReader(Car.class);
        DataFileReader<Car> dataFileReader = new DataFileReader(new File("cars.avro"), userDatumReader);
        Car resultCar = null;

        resultCar = dataFileReader.next();

        return resultCar;
    }
}
