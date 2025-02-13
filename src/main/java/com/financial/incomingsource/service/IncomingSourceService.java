package com.financial.incomingsource.service;

import com.financial.incomingsource.converter.IncomingSourceConverter;
import com.financial.incomingsource.enums.IncomingSourceType;
import com.financial.incomingsource.model.IncomingSourceEntity;
import com.financial.incomingsource.repository.IncomingSourceRepository;
import com.financial.incomingsource.specification.IncomingSourceSpecification;
import com.financial.incomingsource.validator.IncomingSourceSaveValidator;
import com.financial.incomingsource.vo.IncomingSourceVO;
import com.sun.media.sound.InvalidDataException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Log4j2
@Service
public class IncomingSourceService {

    @Autowired
    private IncomingSourceRepository incomingSourceRepository;

    @Autowired
    private IncomingSourceConverter incomingSourceConverter;

    @Autowired
    private IncomingSourceSaveValidator incomingSourceSaveValidator;

    public IncomingSourceVO save(IncomingSourceVO incomingSourceVO) throws InvalidDataException {
        log.info("Starting incoming source saving...");
        IncomingSourceEntity entity = incomingSourceConverter.generate(incomingSourceVO);
        if (nonNull(incomingSourceVO.getId())) {
            Optional<IncomingSourceEntity> returnedEntity = incomingSourceRepository.findById(incomingSourceVO.getId());
            if (!returnedEntity.isPresent()) {
                throw new InvalidDataException("Incoming source not found for update.");
            }
        }
        incomingSourceSaveValidator.validate(entity);
        incomingSourceRepository.save(entity);
        log.info("Incoming source " + entity + " saved successfully.");
        return incomingSourceConverter.convert(entity);
    }

    public void delete(Integer id) throws InvalidDataException {
        log.info("Starting incoming source deleting...");
        if (nonNull(id)) {
            Optional<IncomingSourceEntity> returnedEntity = incomingSourceRepository.findById(id);
            if (!returnedEntity.isPresent()) {
                throw new InvalidDataException("Incoming source not found for delete.");
            }
            incomingSourceRepository.delete(returnedEntity.get());
            log.info("Incoming source " + returnedEntity.get() + " deleted successfully.");
        } else {
            throw new InvalidDataException("Incoming source id not given.");
        }
    }

    public List<IncomingSourceVO> findAll(Integer id, String name, String description, IncomingSourceType type) {
        List<IncomingSourceEntity> incomingSourceList = incomingSourceRepository
                .findAll(new IncomingSourceSpecification(id, name, description, type),
                    Sort.by(Sort.Direction.ASC, "name"));
        return incomingSourceList.stream()
                .map(incomingSource -> incomingSourceConverter.convert(incomingSource))
                .collect(Collectors.toList());
    }
}
