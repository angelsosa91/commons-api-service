package py.com.solar.commonsapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import py.com.solar.commonsapi.entity.MessageEntity;
import py.com.solar.commonsapi.mapper.CommonMapper;
import py.com.solar.commonsapi.mapper.MessageMapper;
import py.com.solar.commonsapi.models.Notification;
import py.com.solar.commonsapi.models.Region;
import py.com.solar.commonsapi.models.enums.NotificationType;
import py.com.solar.commonsapi.repository.CommonRepository;
import py.com.solar.exceptions.BusinessException;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static py.com.solar.commonsapi.models.enums.NotificationType.SMS;
import static py.com.solar.commonsapi.models.enums.NotificationType.EMAIL;
import static py.com.solar.commonsapi.models.enums.NotificationType.AMBOS;
@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final CommonRepository commonRepository;
    private final CommonMapper commonMapper;
    private final MessageMapper messageMapper;
    @Override
    public List<Region> getProvince() {
        return commonMapper.regEntityToModel(commonRepository.getProvince());
    }

    @Override
    public List<Region> getCity(Integer provinceId) {
        return commonMapper.regEntityToModel(commonRepository.getCity(provinceId));
    }

    @Override
    public List<Region> getNeighborhood(Integer cityId) {
        return commonMapper.regEntityToModel(commonRepository.getNeighborhood(cityId));
    }

    @Override
    public CompletableFuture<MessageEntity> sendNotification(Notification notification) {
        CompletableFuture<MessageEntity> future = CompletableFuture.supplyAsync(() -> {
            MessageEntity message = new MessageEntity();

            if (AMBOS.getValue().equals(notification.getNotificationType())) {
                //SMS
                notification.setNotificationType("SM");
                commonRepository.sendNotification(commonMapper.notModelToEntity(notification), message);
                //EMAIL
                notification.setNotificationType("EM");
                commonRepository.sendNotification(commonMapper.notModelToEntity(notification), message);
            } else {
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
}
