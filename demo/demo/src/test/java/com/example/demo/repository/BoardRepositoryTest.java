package com.example.demo.repository;

import com.example.demo.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    //CRUD TEST (insert)
    @Test
    public void testInsert() {
        //IntStream.range(시작, 종료).forEach(i -> {컬럼의 내용을 builder를 이용하여 추가 });
        IntStream.range(1, 10).forEach(i -> {
            Board board = Board.builder()
                    .title("제목 " + i)
                    .content("내용 " + i)
                    .writer("작성자 " + i)
                    .build();
            Board result = boardRepository.save(board);
            /*log.info("bid : " + result.getBid());*/
        });
    }

    @Test
    public void testSelect() throws Exception {
        Long bid = 7L;
        Optional<Board> result = boardRepository.findById(bid);
        Board board = result.orElseThrow(Exception::new);
        log.info(board);
    }

    @Test
    public void testUpdate() throws Exception {
        Long bid = 5L;
        Optional<Board> result = boardRepository.findById(bid);
        Board board = result.orElseThrow(Exception::new);
        board.change("수정", "내용 수정");
        boardRepository.save(board);
    }

    @Test
    public void testSelectAll() {
        List<Board> list = boardRepository.findAll();
        for(Board board : list){
            log.info("post : " +board.toString());
        }
    }

}