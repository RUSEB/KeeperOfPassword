package tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PropertiesGetter {

	public static FileInputStream getFilePropetrie(String namePropertie) throws FileNotFoundException {
		return new FileInputStream("src/main/resources/properties/" + namePropertie + ".properties");
	}
}
