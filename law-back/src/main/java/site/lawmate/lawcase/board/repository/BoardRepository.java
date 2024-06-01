package site.lawmate.lawcase.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import site.lawmate.lawcase.board.model.Board;

import java.util.List;


@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardDao {
    @Query("SELECT b FROM boards b WHERE b.법령명한글 = :법령명한글")
    List<Board> findBy법령명한글(@Param("법령명한글") String 법령명한글);

}
