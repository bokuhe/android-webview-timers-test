# andorid-problem-WebViewTimers

Android M(API 23) 이하의 버전에서 WebView의 resumeTimers, pauseTimers 메소드를 이용할 경우,

다른 WebView 인스턴스를 생성하더라도 기존의 설정이 공유되는 문제가 있다.

**A WebView**에서 pauseTimers 메소드를 호출하고 Destroy된 뒤 다시 **A WebView**가 생성되면, 웹 페이지 내 SetTimer와 같은 타이머 함수가 동작되지 않는다.

이 프로젝트는 해당 문제를 확인하기 위한 예제 프로젝트이며,


pauseTimer만 호출되는 WebView와 resumeTimers, pauseTimers가 호출되는 WebView를 실행하여 두 WebView 동작을 비교해 볼 수 있다.