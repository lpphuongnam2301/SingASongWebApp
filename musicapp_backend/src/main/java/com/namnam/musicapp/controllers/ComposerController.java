package com.namnam.musicapp.controllers;

import com.namnam.musicapp.dtos.reponses.ApiResponse;
import com.namnam.musicapp.dtos.reponses.ComposerResponse;
import com.namnam.musicapp.dtos.reponses.SingerResponse;
import com.namnam.musicapp.dtos.requests.ComposerDTO;
import com.namnam.musicapp.dtos.requests.SingerDTO;
import com.namnam.musicapp.mappers.ComposerMapper;
import com.namnam.musicapp.services.composer.ComposerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/composer")
public class ComposerController {
    private final ComposerService composerService;
    private final ComposerMapper composerMapper;

    @GetMapping("")
    public ApiResponse<List<ComposerResponse>> getAllComposer()
    {
        ApiResponse<List<ComposerResponse>> apiResponse = new ApiResponse<>();

        return apiResponse;
    }

    @PostMapping("/create")
    public ApiResponse<ComposerResponse> createComposer(@RequestBody @Valid ComposerDTO composerDTO)
    {
        ApiResponse<ComposerResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(composerMapper.toComposerResponse(composerService.createComposer(composerDTO)));

        return apiResponse;
    }

    @PostMapping("/update/{id}")
    public ApiResponse<ComposerResponse> updateComposer(@PathVariable Long id, @RequestBody @Valid ComposerDTO composerDTO)
    {
        ApiResponse<ComposerResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(composerMapper.toComposerResponse(composerService.updateComposer(id, composerDTO)));

        return apiResponse;
    }
}
