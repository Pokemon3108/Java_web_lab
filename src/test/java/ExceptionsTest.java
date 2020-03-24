import com.project1.web1.application.EmptyStringException;
import com.project1.web1.application.MyIllegalArgumentException;
import com.project1.web1.controller.StringController;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ExceptionsTest {
    @Test(expectedExceptions = EmptyStringException.class,expectedExceptionsMessageRegExp = "String is empty")
    public void EmptyStringExceptionTest() {
        StringController controller=new StringController();
        String checkedString="";
        controller.decript(checkedString);
        Assert.fail();

    }

    @Test(expectedExceptions=MyIllegalArgumentException.class, expectedExceptionsMessageRegExp = "Illegal string")
    public void MyIllegalArgumentExceptionTest()  {
        StringController controller=new StringController();
        String checkedString="string more than 20 symbols";
        controller.decript(checkedString);
        Assert.fail();

    }
}
