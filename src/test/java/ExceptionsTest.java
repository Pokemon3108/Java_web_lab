import com.project1.web1.application.EmptyStringException;
import com.project1.web1.application.MyIllegalArgumentException;
import com.project1.web1.controller.StringController;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ExceptionsTest {
    @Test
    public void EmptyStringExceptionTest() throws EmptyStringException {
        StringController controller=new StringController();
        String checkedString="";
        Throwable thrown=catchThrowable(()->{
            controller.decript(checkedString);
        });
       assertThat(thrown).isInstanceOf(EmptyStringException.class);
        assertThat(thrown.getMessage()).isNotBlank();

    }

    @Test
    public void MyIllegalArgumentExceptionTest() throws MyIllegalArgumentException {
        StringController controller=new StringController();
        String checkedString="string more than 20 symbols";
        Throwable thrown=catchThrowable(()->{
            controller.decript(checkedString);
        });
        assertThat(thrown).isInstanceOf(MyIllegalArgumentException.class);
        assertThat(thrown.getMessage()).isNotBlank();

    }
}
