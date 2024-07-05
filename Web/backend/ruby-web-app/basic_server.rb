require 'webrick'

server = WEBrick::HTTPServer.new(:Port => 8080)

server.mount_proc '/' do |req, res|
  res.body = '<html><head><title>Basic Ruby Web Server</title></head><body><h1>Hello, World!</h1></body></html>'
end

trap 'INT' do
  server.shutdown
end

server.start

