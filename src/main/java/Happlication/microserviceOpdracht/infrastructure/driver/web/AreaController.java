package Happlication.microserviceOpdracht.infrastructure.driver.web;

import Happlication.microserviceOpdracht.core.application.CommandHandler;
import Happlication.microserviceOpdracht.core.application.port.AreaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {

    private final CommandHandler commandHandler;
    private final AreaRepository areaRepository;

    public AreaController(CommandHandler commandHandler, AreaRepository areaRepository) {
        this.commandHandler = commandHandler;
        this.areaRepository = areaRepository;
    }

    @GetMapping("/{tablenumber}")
    public List<Long> getWaitersForArea(@PathVariable int tablenumber){
        return this.commandHandler.handle(tablenumber);
    }
}
