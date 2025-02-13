package com.financial.incomingsource.controller;

import com.financial.incomingsource.enums.IncomingSourceType;
import com.financial.incomingsource.service.IncomingSourceService;
import com.financial.incomingsource.vo.IncomingSourceVO;
import com.sun.media.sound.InvalidDataException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api("Incoming Source")
@RestController
@RequestMapping(value = "/incoming-source")
public class IncomingSourceController {

    @Autowired
    private IncomingSourceService incomingSourceService;

    @ApiOperation("Method responsible for saving incoming sources.")
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public @ResponseBody ResponseEntity<?> save (@RequestBody final IncomingSourceVO vo) throws InvalidDataException {
        IncomingSourceVO voSaved = incomingSourceService.save(vo);
        return new ResponseEntity<>(voSaved, HttpStatus.CREATED);
    }

    @ApiOperation("Method responsible for deleting incoming sources.")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public @ResponseBody ResponseEntity<?> delete (@RequestBody final Integer id) throws InvalidDataException {
        incomingSourceService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ApiOperation("Method responsible for finding incoming sources.")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public @ResponseBody ResponseEntity<?> findAll (
            @RequestParam(name = "id", required = false) final Integer id,
            @RequestParam(name = "name", required = false) final String name,
            @RequestParam(name = "description", required = false) final String description,
            @RequestParam(name = "type", required = false) final IncomingSourceType type) {
        List<IncomingSourceVO> incomingSourceList = incomingSourceService.findAll(id, name, description, type);
        return new ResponseEntity<>(incomingSourceList, HttpStatus.OK);
    }

}
