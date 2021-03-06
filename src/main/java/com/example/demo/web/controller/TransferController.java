package com.example.demo.web.controller;

import com.example.demo.common.annotation.JwtAction;
import com.example.demo.service.model.TransferDto;
import com.example.demo.service.model.TransferResponseDto;
import com.example.demo.service.spi.TransferService;
import com.example.demo.web.controller.model.ApiResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TransferController {

  private final TransferService transferService;

  @JwtAction("transferencias")
  @PostMapping("/api/transfer")
  public ApiResponse<TransferResponseDto> transfer(@Valid @RequestBody TransferDto transferDto) {
    return ApiResponse.<TransferResponseDto>builder()
      .code("A01")
      .message("Exito")
      .data(transferService.transfer(transferDto))
      .build();
  }

}
