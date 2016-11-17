import pygame
import sys
import random
import Colours as c

class galaxy_map:

    screen_height = 400
    screen_width = 600
    screen_fps = 60
    star_density = 100
    starfield_generated = False
    stars_generated = False

    def __init__(self):
        pygame.init()
        self.display = pygame.display.set_mode((self.screen_width, self.screen_height))

    def generate_background(self):
        starfield = pygame.Surface((self.screen_width, self.screen_height))
        blue1 = random.randint(0, 255)
        blue2 = random.randint(0, 255)
        blue3 = random.randint(0, 255)
        blue4 = random.randint(0, 255)

        for x in range(0, self.screen_width):
            for y in range(0, self.screen_height):
                diff_v = (blue1 - blue2) * x / self.screen_width
                diff_h = (blue3 - blue4) * y / self.screen_height
                avg = abs(diff_v + diff_h)
                if avg < blue4:
                    starfield.set_at((x, y), (0, 0, int(blue4 - avg)))
                else:
                    starfield.set_at((x, y), (0, 0, int(avg - blue4)))

        return starfield

    def generate_stars(self):
        stars = []
        for s in range(0, self.star_density):
            star_x = random.randint(0, self.screen_width)
            star_y = random.randint(0, self.screen_height)
            stars.append((star_x, star_y))
        return stars

    def draw(self):
        pygame.display.set_caption("Test")
        self.clock = pygame.time.Clock()
        self.done = False
        while not self.done:
            for event in pygame.event.get():
                if event.type == pygame.QUIT or (event.type == pygame.KEYUP and event.key == pygame.K_ESCAPE):
                    self.done = True

            # black the map area
            self.display.fill(c.black)

            # render gradient background
            if self.starfield_generated == False:
                starfield = self.generate_background()
                self.starfield_generated = True

            self.display.blit(starfield, (0, 0))

            # render varying strength stars
            if self.stars_generated == False:
                stars = self.generate_stars()
                self.stars_generated = True

            for s in stars:
                colour = c.random
                pygame.draw.line(self.display, colour, (s[0], s[1]), (s[0], s[1] + 1))

            # render star names

            # draw cross hairs

            # draw lock on box

            # detect proximity to star and diplay stats

            # update screen
            pygame.display.flip()
            self.clock.tick(self.screen_fps)

        pygame.quit()

galaxy = galaxy_map().draw()
