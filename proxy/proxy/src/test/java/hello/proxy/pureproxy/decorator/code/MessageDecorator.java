package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component{

    private RealComponent target;

    public MessageDecorator(RealComponent target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");
        String result = target.operation();
        String decoResult = "*****" + result + "*****";
        log.info("적용 전 = {}, 적용 후 = {}", result, decoResult);
        return decoResult;
    }
}
