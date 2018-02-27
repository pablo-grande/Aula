class TextCount(object):
    def __init__(self, text):
        from collections import Counter
        import re

        VOWELS = 'aeiouà-ú'
        ALPHABET = 'A-Za-zà-ú'

        alphabetic = ''.join(re.findall(r'[' + ALPHABET + ']', text, flags=re.I))
        consonants = re.findall(r'[^' + VOWELS + ']', alphabetic, flags=re.I)

        self.__message = Counter(text)
        self.__words = dict(Counter(re.findall(r'\w+', text)))
        self.__vowels = dict(Counter(re.findall(r'[' + VOWELS + ']', text, flags = re.I)))
        self.__consonants = dict(Counter(consonants))
        self.__digits = dict(Counter(re.findall(r'\d', text)))
        self.__special = dict(Counter(re.findall(r'[^' + ALPHABET + ' \d\n]', text)))


    @property
    def vowels(self):
        """
        Returns vowels in a message
        """
        return str(self.__vowels)


    @property
    def consonants(self):
        """
        Returns number of consonants in message
        """
        return sum(self.__consonants.values())


    @property
    def digits(self):
        """
        Returns number of digits in message
        """
        return sum(self.__digits.values())


    @property
    def words(self):
        """
        Returns number of appareances of given word in message
        """
        return self.__words


    @property
    def blanks(self):
        """
        Returns number of blank space characters are in message
        """
        return self.__message[' ']


    @property
    def line_breaks(self):
        """
        Returns number of line breaks are in message
        """
        return self.__message['\n']


    @property
    def special(self):
        """
        Returns number of special characters in message
        """
        return sum(self.__special.values())


    def word(self, a_word):
        if a_word in self.words.keys():
            return self.words[a_word]
        return None


    def __repr__(self):
        return str(dict(self.__message))


if __name__ == '__main__':
    text = ""
    with open('lugar.txt', 'r') as f:
        text = f.read()
    f.close()
    t = TextCount(text)
    print(t)
    print("vowels ", t.vowels)
    print("consonants ", t.consonants)
    print("digits ", t.digits)
    print("blanks ", t.blanks)
    print("line breaks ",t.line_breaks)
    print("special ", t.special)

    print("Palabra 'abc'", t.word('abc'))
    print("Palabra '8abc'", t.word('8abc'))

