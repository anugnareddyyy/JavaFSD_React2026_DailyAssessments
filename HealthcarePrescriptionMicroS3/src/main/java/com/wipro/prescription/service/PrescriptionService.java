
package com.wipro.prescription.service;

import com.wipro.prescription.dto.PrescriptionDTO;
import com.wipro.prescription.mapper.PrescriptionMapper;
import com.wipro.prescription.repository.PrescriptionRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {

    private final PrescriptionRepository repo;
    private final PrescriptionMapper mapper;
    private final RestTemplate restTemplate;

    public PrescriptionService(PrescriptionRepository repo,
                               PrescriptionMapper mapper,
                               RestTemplate restTemplate){

        this.repo = repo;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    // CREATE
    public PrescriptionDTO save(PrescriptionDTO dto){
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    // ✅ GET ALL (CONNECTED)
    public List<PrescriptionDTO> getAll(){
        return repo.findAll().stream().map(p -> {

            PrescriptionDTO dto = mapper.toDTO(p);

            String url = "http://localhost:8081/patients/" + p.getPatientId();
            Object patient = restTemplate.getForObject(url, Object.class);

            dto.setPatientId(patient);

            return dto;

        }).collect(Collectors.toList());
    }

    // ✅ GET BY PATIENT (used by Appointment)
    public List<PrescriptionDTO> getByPatient(int id){
        return repo.findByPatientId(id)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // DELETE
    public void delete(int id){
        repo.deleteById(id);

    }
}
//
//	public PrescriptionDTO save(PrescriptionDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public PrescriptionDTO save1(PrescriptionDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public PrescriptionDTO save1(PrescriptionDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public PrescriptionDTO save1(PrescriptionDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public PrescriptionDTO save1(PrescriptionDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public PrescriptionDTO save1(PrescriptionDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public PrescriptionDTO save1(PrescriptionDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public PrescriptionDTO save1(PrescriptionDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public PrescriptionDTO save1(PrescriptionDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public PrescriptionDTO save1(PrescriptionDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
// }
