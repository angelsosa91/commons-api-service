package py.com.solar.commonsapi.service;

import com.google.common.base.Strings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import py.com.solar.commonsapi.constants.CommonConstants;
import py.com.solar.commonsapi.entity.MessageEntity;
import py.com.solar.commonsapi.mapper.CommonMapper;
import py.com.solar.commonsapi.mapper.MessageMapper;
import py.com.solar.commonsapi.models.Notification;
import py.com.solar.commonsapi.models.Office;
import py.com.solar.commonsapi.models.Region;
import py.com.solar.commonsapi.repository.CommonRepository;
import py.com.solar.exceptions.BadRequestException;
import py.com.solar.exceptions.BusinessException;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static py.com.solar.commonsapi.models.enums.NotificationType.*;
@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final CommonRepository commonRepository;
    private final CommonMapper commonMapper;
    private final MessageMapper messageMapper;
    @Override
    public List<Region> getDepartments() throws Exception {
        try {
            return commonMapper.regEntityToModel(commonRepository.getDepartments());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public List<Region> getCitiesByDepartmentId(Integer departmentId) throws Exception {
        if(departmentId == null)
            throw new BadRequestException("El id del departamento es requerido");

        try {
            return commonMapper.regEntityToModel(commonRepository.getCitiesByDepartmentId(departmentId));
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public List<Region> getNeighborhoodsByCityId(Integer cityId) throws Exception {
        if(cityId == null)
            throw new BadRequestException("El id de la ciudad es requerido");

        try {
            return commonMapper.regEntityToModel(commonRepository.getNeighborhoodsByCityId(cityId));
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public CompletableFuture<MessageEntity> sendNotification(Notification notification) {
        CompletableFuture<MessageEntity> future = CompletableFuture.supplyAsync(() -> {
            MessageEntity message = new MessageEntity();

            if (AMBOS.getValue().equals(notification.getNotificationType())) {
                if(Strings.isNullOrEmpty(notification.getPhoneNumber()) && Strings.isNullOrEmpty(notification.getEmail()))
                    throw new BadRequestException("Email y celuar obligatorio");
                //SMS
                notification.setNotificationType(CommonConstants.SMS);
                commonRepository.sendNotification(commonMapper.notModelToEntity(notification), message);
                //EMAIL
                notification.setNotificationType(CommonConstants.EMAIL);
                commonRepository.sendNotification(commonMapper.notModelToEntity(notification), message);
            } else {
                if(notification.getNotificationType().equals("SM") && Strings.isNullOrEmpty(notification.getPhoneNumber()))
                    throw new BadRequestException("Celular Obligatorio");

                if(notification.getNotificationType().equals("EM") && Strings.isNullOrEmpty(notification.getEmail()))
                    throw new BadRequestException("Email obligatorio");
                //SMS or EMAIL
                commonRepository.sendNotification(commonMapper.notModelToEntity(notification), message);
            }

            if(message.getCodMensaje() > 0)
                throw new BusinessException(message.getMensaje());

            return message;
        });

        future.thenAccept(messageMapper::toModel);
        return future;
    }
    @Override
    public List<Office> getAllOffices() throws Exception {
        try {
            return commonMapper.offEntityToModel(commonRepository.getAllOffices());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
