package org.teavm;

import org.teavm.dom.ajax.ReadyStateChangeHandler;
import org.teavm.dom.ajax.XMLHttpRequest;
import org.teavm.dom.browser.Window;
import org.teavm.dom.html.HTMLButtonElement;
import org.teavm.dom.html.HTMLDocument;
import org.teavm.dom.html.HTMLElement;
import org.teavm.dom.events.Event;
import org.teavm.dom.events.EventListener;
import org.teavm.jso.JS;

import org.teavm.domain.Pessoa;

public class Client {

    private static final Window window = (Window) JS.getGlobal();
    private static final HTMLDocument document = window.getDocument();

    public static void main(String[] args) {
        Client cli = new Client();
        cli.init();
    }
    
    public void init() {
        final HTMLElement div = document.createElement("div");
        document.getBody().appendChild(div);

        HTMLButtonElement button = (HTMLButtonElement) document.getElementById("testeBtn");
        button.addEventListener("click", new EventListener() {
            @Override
            public void handleEvent(Event event) {
                //div.appendChild(document.createTextNode("Teste"));
                test();
            }
        });
    }

    private void test() {
        final XMLHttpRequest xhr = window.createXMLHttpRequest();
        xhr.setOnReadyStateChange(new ReadyStateChangeHandler() {
            @Override
            public void stateChanged() {
                if (xhr.getReadyState() == XMLHttpRequest.DONE) {
                    execute(xhr);
                }
            }
        });
        xhr.open("GET", "pessoas");
        xhr.send();
    }

    private void execute(XMLHttpRequest xhr) {
        System.out.println(xhr.getResponseText());
    }
}
