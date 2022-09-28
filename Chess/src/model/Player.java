package model;

import java.util.UUID;

public class Player {
    public UUID id;
    public String username;
    public Integer turns=0;
    public PieceColor color;

    public Player(String name) {
        this.id = UUID.randomUUID();
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTurns() {
        return turns;
    }

    public void setTurns(Integer turns) {
        this.turns = turns;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }
}
