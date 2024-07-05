from http.server import SimpleHTTPRequestHandler, HTTPServer

hostName = "localhost"
serverPort = 8080

class MyServer(SimpleHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()
        self.wfile.write(bytes("<html><head><title>Basic Python Web Server</title></head>", "utf-8"))
        self.wfile.write(bytes("<body><h1>Hello, World!</h1></body></html>", "utf-8"))

if __name__ == "__main__":
    webServer = HTTPServer((hostName, serverPort), MyServer)
    print(f"Server started http://{hostName}:{serverPort}")

    try:
        webServer.serve_forever()
    except KeyboardInterrupt:
        pass

    webServer.server_close()
    print("Server stopped.")

