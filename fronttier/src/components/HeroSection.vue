<template>
  <section class="py-6 px-4 bg-green-50">
    <h2 class="text-2xl font-bold mb-4 text-green-800">Featured Produce</h2>

    <div class="relative">
      <!-- Keen Slider -->
      <div ref="sliderRef" class="keen-slider">
        <div
          v-for="product in products"
          :key="product.id"
          class="keen-slider__slide"
        >
          <div @click="openModal(product)">
            <Card :product="product" />
          </div>
        </div>
      </div>

      <!-- Modal -->
      <Modal
        v-if="selectedProduct"
        :product="selectedProduct"
        @close="selectedProduct = null"
      />

      <!-- Navigation Arrows
      <button
        @click="sliderInstance?.prev()"
        class="absolute left-0 top-1/2 -translate-y-1/2 bg-white border shadow rounded-full p-2 z-10 hover:bg-green-100"
      >
        ◀
      </button>
      <button
        @click="sliderInstance?.next()"
        class="absolute right-0 top-1/2 -translate-y-1/2 bg-white border shadow rounded-full p-2 z-10 hover:bg-green-100"
      >
        ▶
      </button> -->
      <!-- Navigation Arrows -->
<button
  @click="sliderInstance?.prev()"
  class="absolute left-4 top-1/2 -translate-y-1/2 text-white text-3xl z-10 p-2 rounded-full hover:bg-black/20 transition"
>
  <svg xmlns="http://www.w3.org/2000/svg" class="h-8 w-8" fill="none" viewBox="0 0 24 24" stroke="currentColor">
    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 19l-7-7 7-7" />
  </svg>
</button>

<button
  @click="sliderInstance?.next()"
  class="absolute right-4 top-1/2 -translate-y-1/2 text-white text-3xl z-10 p-2 rounded-full hover:bg-black/20 transition"
>
  <svg xmlns="http://www.w3.org/2000/svg" class="h-8 w-8" fill="none" viewBox="0 0 24 24" stroke="currentColor">
    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
  </svg>
</button>

    </div>
  </section>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useKeenSlider } from 'keen-slider/vue'
import Card from '@/components/Card.vue'
import Modal from '@/components/ProductModal.vue'

const products = ref([])
const selectedProduct = ref(null)

const sliderRef = ref()

const [sliderInstance] = useKeenSlider(sliderRef, {
  loop: true,
  slides: {
    perView: 1,
    spacing: 16,
  },
  breakpoints: {
    '(min-width: 768px)': {
      slides: { perView: 2, spacing: 20 },
    },
    '(min-width: 1024px)': {
      slides: { perView: 3, spacing: 24 },
    },
  },
})

const openModal = (product) => {
  selectedProduct.value = product
}

onMounted(async () => {
  try {
    const res = await fetch('https://localhost:8443/api/products')
    products.value = await res.json()
  } catch (error) {
    console.error('Failed to fetch products:', error)
  }
})
</script>

<style>
html, body {
  max-width: 100%;
  overflow-x: hidden;
}

.keen-slider__slide {
  min-width: 100%;
}

@media (min-width: 768px) {
  .keen-slider__slide {
    min-width: auto;
  }
}
</style>
