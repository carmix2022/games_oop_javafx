package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPositionIsTheSame() {
        BishopBlack bp = new BishopBlack(Cell.C8);
        Cell expected = Cell.C8;
        assertThat(bp.position()).isEqualTo(expected);
    }

    @Test
    void whenWayIsCorrect() {
        BishopBlack bp = new BishopBlack(Cell.C1);
        Cell[] cells = bp.way(Cell.G5);
        Cell expected = Cell.G5;
        assertThat(cells[3]).isEqualTo(expected);
    }

    @Test
    void whenWayIsNotCorrect() {
        BishopBlack bp = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bp.way(Cell.G4)
        );
        String expected = "Could not move by diagonal from C1 to G4";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }

    @Test
    void whenPositionAfterCopyIsCorrect() {
        Figure bp = new BishopBlack(Cell.C8);
        bp = bp.copy(Cell.B7);
        Cell expected = Cell.B7;
        assertThat(bp.position()).isEqualTo(expected);
    }
}