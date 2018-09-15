import http.server
import socketserver

"""
DBサーバ保守用コンソールアプリ(バックエンド)
F.Sakanobe
"""
PORT = 8000 #ポート番号
Handler = http.server.SimpleHTTPRequestHandler #HTTPリクエストハンドラ
"""
WEBサーバ起動処理
"""
with socketserver.TCPServer(("", PORT), Handler) as httpd:
    print("serving at port", PORT)
    httpd.serve_forever()

class DBHostConsole_Controller:
    def __init__(self):
        pass


def terminate():
    print('VoiceRecognition DB Ctl App Run')

terminate()
