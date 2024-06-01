package site.lawmate.lawcase.board;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.lawmate.lawcase.board.model.BoardDto;
import site.lawmate.lawcase.board.service.BoardServiceImpl;

import java.util.List;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/board")
@Slf4j
public class BoardController {
    private final BoardServiceImpl service;
    private final BoardRouter router;

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto>> list(){
        List<BoardDto> result = service.findAll();
        log.info("list result: {}", result); // 로그 추가lawdb
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<?> listByCase(
            @RequestParam(value = "q") String q
    ) {
        return ResponseEntity.ok(router.excute(q));
    }
}
