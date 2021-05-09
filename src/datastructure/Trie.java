package datastructure;

public class Trie {
  private final Node root;

  public Trie() {
    root = new Node('\0');
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.append("cat");
    trie.append("cow");
    trie.append("mat");
    System.out.println(trie.search("cat"));
    System.out.println(trie.search("cats"));
  }

  public void append(String word) {
    Node current = root;
    for (int i = 0; i < word.length(); i++) {
      char currentCharacter = word.charAt(i);
      if (current.children[currentCharacter - 'a'] == null) {
        final Node child = new Node(currentCharacter);
        current.children[currentCharacter - 'a'] = child;
      }
      current = current.children[currentCharacter - 'a'];
    }
    current.isWord = true;
  }

  public boolean search(String word) {
    Node current = root;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (current.children[currentChar - 'a'] == null) {
        return false;
      }
      current = current.children[currentChar - 'a'];
      if (current.isWord && i == word.length() - 1) {
        break;
      }
    }
    return true;
  }

  class Node {
    public char element;
    public Node[] children;
    public boolean isWord;

    public Node(char input) {
      this.element = input;
      this.children = new Node[26];
      this.isWord = false;
    }
  }
}
