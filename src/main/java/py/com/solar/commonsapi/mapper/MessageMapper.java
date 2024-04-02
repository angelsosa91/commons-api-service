package py.com.solar.commonsapi.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import py.com.solar.commonsapi.entity.MessageEntity;
import py.com.solar.commonsapi.models.Message;

@Mapper(componentModel = "spring", uses = {DateUtilMapper.class })
public interface MessageMapper {

    @Mapping(source = "messageId", target = "codMensaje")
    @Mapping(source = "message", target = "mensaje")
    @Mapping(source = "messageType", target = "tipMensaje")
    MessageEntity toEntity(Message model);
    @InheritInverseConfiguration
    Message toModel(MessageEntity entity);
}