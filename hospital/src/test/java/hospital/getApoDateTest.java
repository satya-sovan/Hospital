package hospital;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Test;

import com.hospital.dao.HospitalDAO;
import com.hospital.javabeen.HospitalBO;
import com.hospital.pat.PatService;
import com.hospital.pat.register.PatRegisterControll;

public class getApoDateTest {

	@Test
	public void test() {
		PatService pservice=new PatService();
		System.out.println(pservice.getPatId());
	}

}
