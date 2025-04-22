package org.mps;

import org.junit.jupiter.api.Test;
import org.mps.selection.TournamentSelection;


import static org.junit.jupiter.api.Assertions.*;

public class TournamentSelectionTest {

    @Test
    public void tournamentSelection_tamanoMenor0_throwEvolutionaryAlgorithmException() {
        int tamano = -1;

        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            new TournamentSelection(tamano);
        });
    }

    public void tournamentSelection_tamanoMayor0_True() {
        int tamano = 1;

        //assertDoesNotThrow(EvolutionaryAlgorithmException.class, () -> {
         //   new TournamentSelection(tamano);
        //});
    }
}

