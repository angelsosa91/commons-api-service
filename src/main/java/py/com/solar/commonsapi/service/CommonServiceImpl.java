package py.com.solar.commonsapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import py.com.solar.commonsapi.mapper.CommonMapper;
import py.com.solar.commonsapi.models.Notification;
import py.com.solar.commonsapi.models.Region;
import py.com.solar.commonsapi.repository.CommonRepository;
import py.com.solar.exceptions.BusinessException;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final CommonRepository commonRepository;
    private final CommonMapper commonMapper;
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
    public void sendNotification(Notification notification) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            commonRepository.sendNotification(commonMapper.notModelToEntity(notification));
            return "Message Send!";
        });
        future.thenAccept(result -> System.out.println("The Result: " + result));
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
