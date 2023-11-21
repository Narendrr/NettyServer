# websocket_client.py
import asyncio
import websockets
import time

async def send_receive_messages(uri):
    async with websockets.connect(uri) as websocket:
        while True:
            # Prompt user to enter a message
            message = input("Enter message to send to server (or type 'exit' to quit): ")

            if message.lower() == 'exit':
                break

            # Timestamp the message before sending
            client_timestamp = int(time.time() * 1000)
            message_with_timestamp = f"{message} Client timestamp: {client_timestamp}"

            # Send the message to the server
            await websocket.send(message_with_timestamp)

            # Receive and print the response
            response = await websocket.recv()
            print(f"Received message from server: {response}")

            # Extract server timestamp from the response
            server_timestamp = extract_server_timestamp(response)

            # Calculate and print round-trip latency
            round_trip_latency = int(time.time() * 1000) - server_timestamp
            print(f"Round-trip latency: {round_trip_latency} ms")

def extract_server_timestamp(response):
    parts = response.split("Server timestamp: ")
    if len(parts) == 2:
        try:
            return int(parts[1].strip())
        except ValueError:
            pass
    return 0  # Default value if extraction fails

if __name__ == "__main__":
    asyncio.get_event_loop().run_until_complete(send_receive_messages("ws://localhost:8080/websocket"))
