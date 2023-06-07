package net;

import game.Move;

public interface IMessageProcessor
{
    void process(String message);
    void process(String message, ServerConnection player);
    boolean isCaptureOnLastMove();
    Move getLastMove();
    void setLastMove(Move move);
}
