package com.company;

import javax.swing.*;

class CanvasFrame extends JFrame {
    /**
     * Constructor.
     *
     * @param size  size of the frame (in pixels).
     * @param uni   the Universe to graph.
     * @param time  starting time.
     * @param delay delay between time steps (in milliseconds).
     */
    CanvasFrame(int size, Universe uni, int time, int delay) {
        CanvasPanel panel = new CanvasPanel(size, uni, time, delay);

        this.setTitle(String.format("Cellular Automata with size %d and %d states", uni.size, 10)); ///////10 here is same fix as in canvaspanel

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(size, size);
        this.setResizable(false);

        this.add(panel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
