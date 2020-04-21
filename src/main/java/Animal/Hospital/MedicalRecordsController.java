package Animal.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class MedicalRecordsController {

 @Autowired
 MedicalRecordsService medicalRecordsService;
	 
@RequestMapping(value = "/medical_request",
        method = RequestMethod.GET,
        produces = "application/json;charset=UTF-8")

public boolean medicalRequest(@RequestParam Long reservationId,
					       @RequestParam String doctor,
					       @RequestParam String treatment,
					       @RequestParam String medicalOpinion)
        throws Exception {
        System.out.println("##### /medicalRecords/medicalRequest  called #####");
        
        MedicalRecords medicalRecords = new MedicalRecords();
        
        medicalRecords.setReservationId(reservationId);
        medicalRecords.setDoctor(doctor);
        medicalRecords.setTreatment(treatment);
        medicalRecords.setMedicalOpinion(medicalOpinion);
        
        medicalRecordsService.save(medicalRecords);
        
        Treated treated = new Treated();
        treated.setReservationId(reservationId);
        treated.publish();
        System.out.println("##### 치료완료 이벤트 발송 (Treated)#####");
        
        //Thread.sleep(3000); //2초 대기  부하테스트시  사용  
        
        return true;
        
        }
		
 }
