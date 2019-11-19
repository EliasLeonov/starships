package edu.austral.starship.base.view;

import edu.austral.starship.base.model.PlayerModel;

public class Score implements Valuable {

    private PlayerModel player;

    public Score(PlayerModel player) {
        this.player = player;
    }

    public String getValue() {
        return Integer.toString(player.getPoints());
    }
}
