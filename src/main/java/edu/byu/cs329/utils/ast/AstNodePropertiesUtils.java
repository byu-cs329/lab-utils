package edu.byu.cs329.utils.ast;

import edu.byu.cs329.utils.ExceptionUtils;
import java.util.List;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AstNodePropertiesUtils {
  static final Logger log = LoggerFactory.getLogger(AstNodePropertiesUtils.class);

  public static String getName(TypeDeclaration classDeclaration) {
    return getName(classDeclaration.getName());
  }

  public static String getName(FieldDeclaration field) {
    return getName(field.fragments());
  }

  public static String getName(MethodDeclaration method) {
    return getName(method.getName());
  }

  public static String getName(VariableDeclaration declaration) {
    return getName(declaration.getName());
  }

  public static String getName(VariableDeclarationStatement declaration) {
    return getName(declaration.fragments());
  }

  public static String getName(SimpleName name) {
    return name.getIdentifier();
  }

  private static String getName(Object fragments) {
    VariableDeclaration declaration = AstNodePropertiesUtils.getFragment(fragments);
    return getName(declaration.getName());
  }

  public static Expression getInitializer(VariableDeclarationStatement declarationStatement) {
    VariableDeclaration declaration = getFragment(declarationStatement.fragments());
    return declaration.getInitializer();   
  }

  public static SimpleName getSimpleName(VariableDeclarationStatement declarationStatement) {
    VariableDeclaration declaration = getFragment(declarationStatement.fragments());
    return declaration.getName();   
  }
  
  private static VariableDeclaration getFragment(Object fragments) {
    @SuppressWarnings("unchecked")
    List<VariableDeclaration> fragmentList = (List<VariableDeclaration>) fragments;
    if (fragmentList.size() > 1) {
      ExceptionUtils.throwRuntimeException("only one VariableDeclaration is allowed in fragments");
    }

    return fragmentList.get(0);
  }
}
