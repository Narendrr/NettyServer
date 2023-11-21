package com.nettyServer;// WebSocketServerHandler.java
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.*;

import java.time.Instant;

public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof WebSocketFrame) {
            handleWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        if (frame instanceof TextWebSocketFrame) {
            TextWebSocketFrame textFrame = (TextWebSocketFrame) frame;
            String receivedText = textFrame.text();
            System.out.println("Received text: " + receivedText);

            // Extract client timestamp from the received message
            long clientTimestamp = extractClientTimestamp(receivedText);

            // Calculate and print round-trip latency
            long roundTripLatency = Instant.now().toEpochMilli() - clientTimestamp;
            System.out.println("Round-trip latency: " + roundTripLatency + " ms");

            // Echo the received text back to the client with the server timestamp
            String echoedMessage = "Server echo: " + receivedText + " Server timestamp: " + Instant.now().toEpochMilli();
            ctx.writeAndFlush(new TextWebSocketFrame(echoedMessage));
        }
        // ... (handle other WebSocket frame types if necessary)
    }

    private long extractClientTimestamp(String receivedText) {
        String[] parts = receivedText.split("Client timestamp: ");
        if (parts.length == 2) {
            try {
                return Long.parseLong(parts[1].trim());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0L; // Default value if extraction fails
    }
}
