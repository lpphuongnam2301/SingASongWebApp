package com.namnam.musicapp.controllers;

import com.namnam.musicapp.dtos.reponses.ApiResponse;
import com.namnam.musicapp.dtos.reponses.SingerResponse;
import com.namnam.musicapp.dtos.requests.SingerDTO;
import com.namnam.musicapp.entities.Singer;
import com.namnam.musicapp.mappers.SingerMapper;
import com.namnam.musicapp.services.singer.SingerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/singer")
public class SingerController {
    private final SingerService singerService;
    private final SingerMapper singerMapper;

    @GetMapping("")
    public ApiResponse<List<SingerResponse>> getAllSinger()
    {
        ApiResponse<List<SingerResponse>> apiResponse = new ApiResponse<>();

        return apiResponse;
    }

    @PostMapping("/create")
    public ApiResponse<SingerResponse> createSinger(@RequestBody @Valid SingerDTO singerDTO)
    {
        ApiResponse<SingerResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(singerMapper.toSingerResponse(singerService.createSinger(singerDTO)));

        return apiResponse;
    }

    @PostMapping("/update/{id}")
    public ApiResponse<SingerResponse> updateSinger(@PathVariable Long id, @RequestBody @Valid SingerDTO singerDTO)
    {
        ApiResponse<SingerResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(singerMapper.toSingerResponse(singerService.updateSinger(id, singerDTO)));

        return apiResponse;
    }
}
