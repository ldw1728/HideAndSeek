# HideAndSeek
java socket network game

## 내용   
학교 네트워크 수업의 프로젝트로 제작한 소켓 기반의 멀티플레이 게임.    
술래를 피해 맵에 숨겨져있는 열쇠를 찾아 문을 열어 탈출.

## 설명
 - 도망자 3명과 살인자 1명으로 구성.
 - 도망자는 맵을 돌아 다니며 숨겨진 열쇠 3개를 획득 시 특정지역에 문이 생성.
 - 살인마는 도망자를 공격할 수 있으며 공격받을 시 살인마로 역할 변경.
 - 모두가 살인마가 될 시 살인마 win, 한 명이라도 탈출 성공 시 도망자 win.
 
 ## 기능
 - java socket 사용하여 클라이언트, 서버 구현
 - 캔버스에 이미지를 표현하는 방법으로 구현, 움직임표현은 gif로 표현
 - 모든 object에 rect객체 및 좌표값을 사용하여 충돌처리.
 - 클라이언트에서 서버로 전달되는 데이터의 첫 바이트는 command를 표현하며    
 서버는 각 클라이언트의 행동을 판단.
 
 ## 구동
<img src="/HideAndSeek/c1.PNG" width="400" height="250"></img>
<img src="/HideAndSeek/c2.PNG" width="400" height="250"></img>
<img src="/HideAndSeek/server1.PNG" width="400" height="250"></img>
<img src="/HideAndSeek/s2.PNG" width="400" height="250"></img>
<img src="/HideAndSeek/v1.PNG" width="400" height="250"></img>
<img src="/HideAndSeek/v2.PNG" width="400" height="250"></img>
<img src="/HideAndSeek/v3.PNG" width="400" height="250"></img>
<img src="/HideAndSeek/v4.PNG" width="400" height="250"></img>
<img src="/HideAndSeek/v5.PNG" width="400" height="250"></img>
<img src="/HideAndSeek/v6.PNG" width="400" height="250"></img>
 
 
 



