package com.example.demo.BusinessLayer;

import com.example.demo.PersistanceLayer.RepositoryDream;

import com.example.demo.dtos.DreamDto;
import jakarta.transaction.Transactional;
import com.example.demo.models.Dream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DreamServiceImpl implements DreamService{
        Logger logger = LoggerFactory.getLogger(DreamServiceImpl.class);

        @Autowired
        private RepositoryDream repositoryDream;

        @Override
        public DreamDto save(DreamDto dreamDto) {
            Dream dream = new Dream(
                    dreamDto.getId(),
                    dreamDto.getDuration(),
                    dreamDto.getEnergyLevel(),
                    dreamDto.getStress(),
                    dreamDto.getDate()
            );
            try {
                Dream createdDream = repositoryDream.save(dream);
                DreamDto createdDreamDto = new DreamDto(
                        createdDream.getId(),
                        createdDream.getDuration(),
                        createdDream.getEnergyLevel(),
                        createdDream.getStress(),
                        createdDream.getDate()
                );
                createdDreamDto.setId(createdDream.getId());
                return createdDreamDto;
            } catch (DataAccessException exception) {
                logger.error(exception.getMessage());
                throw exception;
            }
        }

        @Override
        @Transactional
        public void update(DreamDto dream) {
            try {
                repositoryDream.findById(dream.getId())
                        .ifPresent(entity -> {
                            entity.setId(dream.getId());
                            entity.setDuration(dream.getDuration());
                            entity.setEnergyLevel(dream.getEnergyLevel());
                            entity.setStress(dream.getStress());
                            entity.setDate(dream.getDate());
                        });
            } catch (DataAccessException exception) {
                logger.error(exception.getMessage());
                throw exception;
            }

        }

        @Override
        public void delete(Long id) {
            try {
                repositoryDream.deleteById(id);
            } catch (DataAccessException exception) {
                logger.error(exception.getMessage());
                throw exception;
            }
        }

        @Override
        public List<DreamDto> findAll() {
            try {
                return repositoryDream.findAll().stream()
                        .map(item -> {
                            DreamDto dream11 = new DreamDto(
                                    item.getId(),
                                    item.getDuration(),
                                    item.getEnergyLevel(),
                                    item.getStress(),
                                    item.getDate()
                            );
                            dream11.setId(item.getId());
                            return dream11;
                        }).toList();
            } catch (DataAccessException exception) {
                logger.error(exception.getMessage());
                throw exception;
            }
        }
}
