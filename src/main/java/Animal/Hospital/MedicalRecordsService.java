package Animal.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordsService {
	
	@Autowired
	private MedicalRecordsRepository medicalRecordsRepository;

	public void save(MedicalRecord medicalRecords) {
		medicalRecordsRepository.save(medicalRecords);
	}
	
}
