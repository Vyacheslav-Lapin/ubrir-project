package ru.vlapin.experiments.ubrirproject.controller.server;

import com.medium.types.calculator.AdditionInput;
import com.medium.types.calculator.DivisionInput;
import com.medium.types.calculator.MultiplicationInput;
import com.medium.types.calculator.ObjectFactory;
import com.medium.types.calculator.Output;
import com.medium.types.calculator.SubtractionInput;
import lombok.val;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class Controller {

  @ResponsePayload
  @PayloadRoot(
      namespace = "http://medium.com/types/calculator",
      localPart = "AdditionInput")
  public Output addition(@RequestPayload AdditionInput input) {

    val output = new ObjectFactory().createOutput();

    val x = input.getNumber1();
    val y = input.getNumber2();

    output.setResult(x + y);

    return output;
  }

  @ResponsePayload
  @PayloadRoot(
      namespace = "http://medium.com/types/calculator",
      localPart = "SubtractionInput")
  public Output subtraction(@RequestPayload SubtractionInput input) {
    val output = new ObjectFactory().createOutput();
    output.setResult(input.getNumber1() - input.getNumber2());
    return output;
  }

  @ResponsePayload
  @PayloadRoot(
      namespace = "http://medium.com/types/calculator",
      localPart = "MultiplicationInput")
  public Output multiplication(@RequestPayload MultiplicationInput input) {
    val output = new ObjectFactory().createOutput();
    output.setResult(input.getNumber1() * input.getNumber2());
    return output;
  }

  @ResponsePayload
  @PayloadRoot(
      namespace = "http://medium.com/types/calculator",
      localPart = "DivisionInput")
  public Output division(@RequestPayload DivisionInput input) {
    val output = new ObjectFactory().createOutput();
    val x = input.getNumber1();
    val y = input.getNumber2();

    if (y == 0) throw new IllegalArgumentException("Divisor can't be null");

    output.setResult(x / y);

    return output;
  }
}
