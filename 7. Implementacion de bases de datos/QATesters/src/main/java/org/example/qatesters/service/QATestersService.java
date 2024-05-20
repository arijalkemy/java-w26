package org.example.qatesters.service;

import org.example.qatesters.DTO.RequestQATesterDTO;
import org.example.qatesters.model.QATestersModel;
import org.example.qatesters.repository.IQATestersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class QATestersService implements IQATestersService{

    private final IQATestersRepository qatestersRepository;

    static final ModelMapper modelMapper = new ModelMapper();

    public QATestersService(IQATestersRepository qatestersRepository) {
        this.qatestersRepository = qatestersRepository;
    }


    @Override
    @Transactional
    public RequestQATesterDTO createQATester(RequestQATesterDTO requestQATesterDTO) {
        QATestersModel qatestersModel = modelMapper.map(requestQATesterDTO, QATestersModel.class);

        QATestersModel requestQATester = qatestersRepository.save(qatestersModel);

        return modelMapper.map(requestQATester, RequestQATesterDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequestQATesterDTO> getAllQATesters() {
        List<QATestersModel> listQATester =  qatestersRepository.findAll();
        return listQATester.stream().map(qatestersModel -> modelMapper.map(qatestersModel, RequestQATesterDTO.class)).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public RequestQATesterDTO getQATesterById(Long id) {
        QATestersModel qaTestersModel = qatestersRepository.findById(id).orElse(null);
        return modelMapper.map(qaTestersModel, RequestQATesterDTO.class);
    }

    @Override
    @Transactional
    public RequestQATesterDTO updateQATester(Long id, RequestQATesterDTO requestQATesterDTO) {
        QATestersModel qaTestersModel = qatestersRepository.findById(id).orElse(null);

        qaTestersModel.setDescription(requestQATesterDTO.getDescription());
        qaTestersModel.setTested(requestQATesterDTO.isTested());
        qaTestersModel.setPassed(requestQATesterDTO.isPassed());
        qaTestersModel.setNumberOfTries(requestQATesterDTO.getNumberOfTries());
        qaTestersModel.setLastUpdate(LocalDate.now());

        QATestersModel responseQaTestersModel = qatestersRepository.save(qaTestersModel);
        return modelMapper.map(responseQaTestersModel, RequestQATesterDTO.class);
    }

    @Override
    public void deleteQATester(Long id) {
        qatestersRepository.findById(id).orElse(null);
        qatestersRepository.deleteById(id);
    }

    @Override
    public List<RequestQATesterDTO> getTestCasesByStatus(LocalDate lastUpdated) {

        List<QATestersModel> qaTestersModelList = qatestersRepository.findAll()
                .stream().filter(qaTestersModel -> qaTestersModel.getLastUpdate().isEqual(lastUpdated)).toList();
        return qaTestersModelList.stream().map(qaTestersModel -> modelMapper.map(qaTestersModel, RequestQATesterDTO.class)).toList();
    }
}
