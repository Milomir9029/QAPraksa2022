package methods;
import java.io.IOException;

public class SetUp {
    private PropertyFile property = new PropertyFile();
    public void setProperty() throws IOException {
        System.setProperty(property.getProperty("driver"), property.getProperty("driverPath"));
    }

}
