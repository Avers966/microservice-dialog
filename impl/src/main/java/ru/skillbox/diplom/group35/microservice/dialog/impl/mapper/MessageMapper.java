package ru.skillbox.diplom.group35.microservice.dialog.impl.mapper;

import org.mapstruct.*;
import ru.skillbox.diplom.group35.library.core.dto.streaming.MessageDto;
import ru.skillbox.diplom.group35.microservice.dialog.api.dto.message.MessageShortDto;
import ru.skillbox.diplom.group35.microservice.dialog.domain.model.Message;


/**
 * MessageMapper
 *
 * @author Georgii Vinogradov
 */

@Mapper(componentModel = "spring")
public interface MessageMapper {
    @Mapping(target = "dialogId", ignore = true)
    MessageDto toMessageDto(Message message);

    Message toMessage(MessageDto messageDto);

    @AfterMapping
    default void setDialogId(Message message, @MappingTarget MessageDto messageDto) {
        messageDto.setDialogId(message.getDialog().getId());
    }

    MessageShortDto toShortMessageDto(Message message);
}
