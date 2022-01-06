package io.jojun.gof;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Slf4j
@SpringBootApplication
public class GofApplication {
    private static final String TAG = "GofApplication";

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SpringApplication.run(GofApplication.class, args);
        log.info(TAG + " - Server is listening.");

        //Singleton Practice
        /*
        Settings settings = new Settings();
        Settings settings1 = new Settings();
        System.out.println(settings == settings1);
        */

        /*
        Settings settings = Settings.getInstance();
        Settings settings1 = Settings.getInstance();
        System.out.println(settings == settings1);
        */

        /*
        Settings settings = Settings.getInstance();
        Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings settings1 = constructor.newInstance();
        System.out.println(settings1 == settings);
        */

        /*
        Settings settings = Settings.getInstance();
        Settings settings1 = null;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(settings);
        }
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            settings1 = (Settings) in.readObject();
        }
        System.out.println(settings == settings1);
        */
    }

}
