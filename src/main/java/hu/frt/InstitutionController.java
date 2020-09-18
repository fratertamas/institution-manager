package hu.frt;

import hu.frt.EducationalInstitution;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InstitutionController {
    @GetMapping("hello")
    public String hello(){
        return "Hali";
    }

    @PostMapping("educationInstitution")
    public String educationInstitution(@RequestBody EducationalInstitution educationInstitution){
        String result = checkEducationInstitution(educationInstitution);

        return educationInstitution.getInstitutionData().getOmIdentificationNumber();
    }

    private String checkEducationInstitution(EducationalInstitution educationInstitution) {
        final String uri = "http://localhost:8082/institution-check";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri, educationInstitution,String.class);
        System.out.println(result);
        return result;
    }

}
