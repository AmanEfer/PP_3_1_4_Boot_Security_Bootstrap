package com.amanefer.telegram.commands;

import com.amanefer.telegram.dto.UserDto;
import com.amanefer.telegram.services.RestToCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class UserDataCommand implements Command {

    public static final String GET_MY_DATA_COMMAND = "get my data";

    private final RestToCrud rest;


    @Override
    public boolean support(String command) {

        return command.equalsIgnoreCase(GET_MY_DATA_COMMAND);
    }

    @Override
    public SendMessage process(Message msg) {

        UserDto user = rest.getUser(msg.getFrom().getId());

        return new SendMessage(String.valueOf(msg.getChatId()), user.toString());
    }

}
