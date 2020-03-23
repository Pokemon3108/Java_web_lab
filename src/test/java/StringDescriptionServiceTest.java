import com.project1.web1.application.EmptyStringException;
import com.project1.web1.controller.StringController;
import com.project1.web1.service.StringDescriptionService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringDescriptionServiceTest {

    @Test
    public void isPolyndrom() {
        StringDescriptionService service=new StringDescriptionService();
        String checkedString="gog";
        String expectedString="Да";
        assertEquals(service.isPolyndrom(checkedString),expectedString);
    }

    @Test
    public void stringLength() {
        StringDescriptionService service=new StringDescriptionService();
        String checkedString="gog";
        int len=3;
        assertEquals(len,service.StringLength(checkedString));
    }

    @Test
    public void notPolyndrom(){
        StringDescriptionService service=new StringDescriptionService();
        String checkedString="cat";
        String expectedString="Нет";
        assertEquals(service.isPolyndrom(checkedString),expectedString);
    }


}