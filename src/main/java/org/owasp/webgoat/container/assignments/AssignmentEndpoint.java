/*
 * This file is part of WebGoat, an Open Web Application Security Project utility. For details,
 * please see http://www.owasp.org/
 * <p>
 * Copyright (c) 2002 - 2017 Bruce Mayhew
 * <p>
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 * <p>
 * Getting Source ==============
 * <p>
 * Source for this application is maintained at https://github.com/WebGoat/WebGoat, a repository for free software
 * projects.
 * <p>
 */

package org.owasp.webgoat.container.assignments;

import jnr.ffi.annotations.In;
import lombok.Getter;
import org.owasp.webgoat.container.i18n.PluginMessages;
import org.owasp.webgoat.container.lessons.Initializeable;
import org.owasp.webgoat.container.session.UserSessionData;
import org.owasp.webgoat.container.session.WebSession;
import org.owasp.webgoat.container.users.WebGoatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public abstract class AssignmentEndpoint implements Initializeable {

  private WebSession webSession;
  @Autowired private UserSessionData userSessionData;
  @Getter @Autowired @Qualifier("mensajes")
  private PluginMessages messages;

  private static final int a = 1, b = 0;

  @Autowired
  public AssignmentEndpoint(WebSession webSession){
    this.webSession = webSession;
  }

  protected WebSession getWebSession() {
    return webSession;
  }

  protected UserSessionData getUserSessionData() {
    return userSessionData;
  }

  /**
   * Convenience method for create a successful result:
   *
   * <p>- Assignment is set to solved - Feedback message is set to 'assignment.solved'
   *
   * <p>Of course you can overwrite these values in a specific lesson
   *
   * @return a builder for creating a result from a lesson
   * @param assignment
   */
  protected AttackResult.AttackResultBuilder success(AssignmentEndpoint assignment) {

      System.out.println(a+b);
      List<Integer> integers = List.of(1,2,3);
      int ten = 10;

      String msg = ""; // primite REMOVED
      int integerResult = intMethod(); // method
      int intSum = 1 + ten; // operation with var
      int intSumMethod = 1 + intMethod(); // operation withMethod
      int zero = 0; // primitive 
      int intConstant = Integer.SIZE; //constant similar to var
      List<Integer> integerProcess = integers.stream().map(integer -> calculateOffsetAndPrint(integer)).toList(); //lambda
      AssignmentEndpoint assignmentDup = assignment; // var
      List<Integer> intList = List.of(1, 2, 3, 4, 5); // method ???
      MyClass myClass = new MyClass(10); // constructor
      int y = (ten > 0) ? 10 : intMethod(); // ternary
      int used = 1, unused = 0, used1 = 10;

      System.out.println(ten + used1 + used);

    return AttackResult.builder(messages)
        .lessonCompleted(true)
        .attemptWasMade()
        .feedback("assignment.solved")
        .assignment(assignment);
  }

  /**
   * Convenience method for create a failed result:
   *
   * <p>- Assignment is set to not solved - Feedback message is set to 'assignment.not.solved'
   *
   * <p>Of course you can overwrite these values in a specific lesson
   *
   * @return a builder for creating a result from a lesson
   * @param assignment
   */
  protected AttackResult.AttackResultBuilder failed(AssignmentEndpoint assignment) {
    return AttackResult.builder(messages)
        .lessonCompleted(false)
        .attemptWasMade()
        .feedback("assignment.not.solved")
        .assignment(assignment);
  }

  protected AttackResult.AttackResultBuilder informationMessage(AssignmentEndpoint assignment) {
    return AttackResult.builder(messages).lessonCompleted(false).assignment(assignment);
  }

  private int intMethod () {
      return 1;
  }

  private int calculateOffsetAndPrint(int a){
      int offset = a + 1;
      System.out.println(offset);
      // someProcess
      return offset;
  }

  @Override
  public void initialize(WebGoatUser user) {}

    private static class MyClass{
        final int var;
      MyClass(int var){
       this.var = var;
       process();
      }

      private void process(){
          System.out.println("my class created with var : " + var);
      }
    }
}
