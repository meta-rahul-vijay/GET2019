package com.Rahul;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestStack {
	
	@Test()
	public void evaluateExpression(){
		System.out.println("Stack");
		Evaluate eval = new Evaluate();
		System.out.println(eval.evaluateExpression("2 * 3 / 5 - 9 * 8 + 1"));
		assertThat(eval.evaluateExpression("2 * 3 / 5 - 9 * 8 + 1"), is(-70));
		//assertThat(eval.evaluateExpression(""), is(-70));
	}
}
